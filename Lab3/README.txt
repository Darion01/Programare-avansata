Am creat clasele Network, Node, Computer, Router, Switch si cele 2 interfete Identifiable si Storage. 
 - Node este o clasa abstracta si este extinsa de Computer, Router si Switch
 - Am folosit HashMap pentru a memora costul fiecarei calculator, ruter sau switch care il pun in lista.
 - Clasa Router implementeaza interfata Identifiable deoarece este identificata de IP.
 - Clasa Computer implementeaza interfata Identifiable si Storage deoarece este identificata atat de IP cat si de storage data.
 - In clasa Network am creat o lista prin care vom afisa pe ecran numele calculatoarelor, ruterelor si switch-urilor. Clasa contine o functie addNodes() prin care adaugam nodurile in lista iar prin functia toString() vom afisa pe ecran.
 - Am implementat functia compareTo() care compara numele a doua noduri. 