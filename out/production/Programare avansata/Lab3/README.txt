Am creat clasele Network, Node, Computer, Router, Switch si cele 2 interfete Identifiable si Storage. 
 - Node este o clasa abstracta si este extinsa de Computer, Router si Switch
 - Am folosit HashMap pentru a memora costul fiecarei calculator, ruter sau switch care il pun in lista.
 - Clasa Router implementeaza interfata Identifiable deoarece este identificata de IP.
 - Clasa Computer implementeaza interfata Identifiable si Storage deoarece este identificata atat de IP cat si de storage data.
 - In clasa Network am creat o lista prin care vom afisa pe ecran numele calculatoarelor, ruterelor si switch-urilor. Clasa contine o functie addNodes() prin care adaugam nodurile in lista iar prin functia toString() vom afisa pe ecran.
 - Am implementat functia compareTo() care compara numele a doua noduri. 





 Sa se afiseze nume, prenumele, nr de prieteni si media pentru studentii cu cei mai multi prieteni. 
Ca sa rezolvati cerinta mai intai v-as indica sa rezolvati selectul pe care se va baza de fapt tot codul vostru PLSQL. Intai verificati pentru fiecare student in parte cati prieteni are (optional ordonati descrescator pentru a evidentia studentii cu cei mai multi amici).

select nume, prenume, s.id, count(p.id) nr_prieteni from studenti s join prieteni p on s.id=p.id_student1 or s.id=p.id_student2 group by nume, prenume, s.id order by 3 desc;

-- de exemplu in baza mea de date am 3 studenti cu acelasi numar maxim de prieteni
Acum obtinem studentul/studentii cu cei mai multi amici. Daca aveti norocul sa obtineti un singur student problema se poate rezolva simplu cu un Select INTO, insa de cele mai multe ori este posibil sa primiti mai multe inregistrari si asta inseamna ca vom folosi un cursor explicit.

select nume, prenume, s.id, count(p.id) nr_prieteni,(select round(avg(valoare),2) from note n where n.id_student=s.id) media
    from studenti s join prieteni p 
    on s.id=p.id_student1 or s.id=p.id_student2 group by nume, prenume, s.id
    having count(p.id)=(select max(count(p.id)) from studenti s join prieteni p 
    on s.id=p.id_student1 or s.id=p.id_student2 group by s.id);

Atentie, nu facem join direct intre cele trei tabele, studenti, prieteni si note si va las pe voi sa intelegeti sau mai bine spus sa testati. Doar sa retineti ca un student nu are sute de prieteni.
-- codul PLSQL 
set serveroutput on;
DECLARE
cursor info_stud is
    select nume, prenume, count(p.id) nr_prieteni,(select round(avg(valoare),2) from note n where n.id_student=s.id) media
    from studenti s join prieteni p on s.id=p.id_student1 or s.id=p.id_student2 
    group by nume, prenume, s.id
    having count(p.id)=(select max(count(p.id)) from studenti s join prieteni p 
                        on s.id=p.id_student1 or s.id=p.id_student2 group by s.id);
v_info_stud info_stud%rowtype;
BEGIN
DBMS_OUTPUT.PUT_LINE('Studentii cu cei mai multi prieteni sunt');
open info_stud;
    loop fetch info_stud into v_info_stud;
    exit when info_stud%notfound;
    DBMS_OUTPUT.PUT(info_stud%rowcount||'. '||v_info_stud.nume||' '||v_info_stud.prenume||
                        ' cu '||v_info_stud.nr_prieteni||' prieteni ');
    DBMS_OUTPUT.PUT_line('si are media '||v_info_stud.media);
    end loop;
close info_stud;
End;
SAU, o alta varianta este sa ne folosim de nr maxim de prieteni pe care un student il poate avea ca si parametru al cursorului.
DECLARE
cursor info_stud(p number) is
    select nume, prenume, count(p.id) nr_prieteni,(select round(avg(valoare),2) from note n where n.id_student=s.id) media
    from studenti s join prieteni p on s.id=p.id_student1 or s.id=p.id_student2 
    group by nume, prenume, s.id
    having count(p.id)=p;
v_info_stud info_stud%rowtype;
nr_amici number;
BEGIN
select max(count(p.id)) INTO nr_amici from studenti s join prieteni p 
    on s.id=p.id_student1 or s.id=p.id_student2 group by s.id;
DBMS_OUTPUT.PUT_LINE('Studentii cu cei mai multi prieteni '||nr_amici||' sunt');
open info_stud(nr_amici);
    loop fetch info_stud into v_info_stud;
    exit when info_stud%notfound;
    DBMS_OUTPUT.PUT_Line(info_stud%rowcount||'. '||v_info_stud.nume||' '||v_info_stud.prenume||' cu media '||v_info_stud.media);
    end loop;
close info_stud;
End;
Exemplele de mai sus sunt doar doua variante posibilile de rezolvare a problemei, va las pe voi sa optimizati codul, sa parcurgeti altfel cursorul sau chiar sa nu folositi deloc cursorul explicit. Spor la treaba si as fi foarte incantata daca mi-ati timite si mie varianta voastra proprie si personala :)  
Mai departe as vrea sa ating un pic subiectul atributelor cursoarelor si sa testam cum le putem utiliza
De exemplu, daca se intampla sa nu avem date in baza noastra de date, s-a intamplat ceva si tabelele sunt goale putem testa astfel.
Stergeti datele din tabela prieteni, testati si apoi faceti rollback.
    --  select count(*) from prieteni;   
    --  delete prieteni;
    --  rollback;
DECLARE
cursor info_stud is
    select nume, prenume, count(p.id) nr_prieteni,(select round(avg(valoare),2) from note n where n.id_student=s.id) media
    from studenti s join prieteni p on s.id=p.id_student1 or s.id=p.id_student2 
    group by nume, prenume, s.id
    having count(p.id)=(select max(count(p.id)) from studenti s join prieteni p 
                        on s.id=p.id_student1 or s.id=p.id_student2 group by s.id);
v_info_stud info_stud%rowtype;

BEGIN
--verificare la urma cu rowcount=0 daca sunt date in tabel. 
/*
open info_stud;
--inainte de primul fetch rowcount este 0, notfound este null
    loop fetch info_stud into v_info_stud;
    exit when info_stud%notfound; --cand nu se gaseste inregistrare %notfound devine true si se iese
    DBMS_OUTPUT.PUT_Line(info_stud%rowcount||'. '||v_info_stud.nume||' '||v_info_stud.prenume||
                                 ' cu media '||v_info_stud.media);
    end loop;
if info_stud%rowcount=0 then DBMS_OUTPUT.PUT_Line('Cursorul este gol');
end if;
close info_stud;
End;
/* 
--Acum testati varianta cu FOR cursor daca aveti acces la aceste atribute atunci cand nu sunt date in baza de date 
for v_info_stud in info_stud loop 
    if info_stud%found then  -- testam cu %found 
    DBMS_OUTPUT.PUT_Line(info_stud%rowcount||'. '||v_info_stud.nume||' '||v_info_stud.prenume||
                                 ' cu media '||v_info_stud.media);
    else DBMS_OUTPUT.PUT_Line('Nu avem date');
end if;
end loop;
-- sau puteti test pe rand si varianta cu rowcount pentru cazul in care nu sunt date
--if info_stud%rowcount=0 then DBMS_OUTPUT.PUT_Line('Nu avem date'); end if;
End;
*/
-- de fapt nu se intra in FOR cand cursorul este gol
Observatie 1: acestea sunt doar niste exemple, va rog sa le testati si sa modificati/imbunatatiti codul cum credeti voi mai bine, va las voua placerea de a descoperi noi variante; 
Observatie 2: exista si alta posibilitate de a testa daca o tabela are date, folosind un simplu select, va las pe voi sa descoperiti, cred ca am discutat deja cu unii dintre voi la laborator;
Observatie 3: cu ajutorul cursorului explicit puteti avea un control mai mare asupra parcurgerii inregistrarilor/cursorului;
Observatie 4: daca folositi cursor in cursor, varianta in care deschideti voi explicit cursoarele cu open, nu uitati intai sa inchideti cursorul imbricat si apoi cursorul extern.