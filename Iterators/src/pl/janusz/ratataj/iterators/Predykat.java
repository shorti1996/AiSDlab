package pl.janusz.ratataj.iterators;

import java.util.function.Predicate;

/**
 * Created by shorti1996 on 22.02.2016.
 */
private class Predykat implements Predicate
{
    public boolean accept(Object z)
    {
        return ((Zawodnik)z).punkty >2;
    }
}
