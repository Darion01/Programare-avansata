package Event;

import java.util.Comparator;

public class EventComparator implements Comparator<Event>
{
    public int compare(Event a, Event b)
    {
        var aux = a.getStartTime() - b.getStartTime();
        if(aux != 0)
            return aux;
        return a.getEntTime() - b.getEntTime();
    }
}