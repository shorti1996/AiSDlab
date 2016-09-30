package com.wojciechliebert.lab03;
import java.util.Iterator;


/**
 * Created by shorti1996 on 09.03.2016.
 */
    // zestaw metod ułatwiających implementację list
    public abstract class AbstractList implements List
    {
        // wydruk wszystkich elementów listy
        public String toString() {
            StringBuffer buffer = new StringBuffer();
            buffer.append('[');
            if (!isEmpty()) {
                Iterator i = iterator();
                for (/*i.first()*/; i.hasNext(); /*i.next()*/)
                    buffer.append(i.next()).append(", ");
                buffer.setLength(buffer.length() - 2);
            }
            buffer.append(']');
            return buffer.toString();
        }

        // ^ - bitowa różnica symetryczna
        public int hashCode() {
            int hashCode = 0;
            Iterator i = iterator();
            for (/*i.first()*/; i.hasNext(); /*i.next()*/)
                hashCode ^= i.next().hashCode();
            return hashCode;
        }

        public boolean equals(Object object) {
            return object instanceof List ? equals((List) object) : false;
        }

        public boolean equals(List other) {
            if (other == null || size() != other.size())
                return false;
            else { Iterator i = iterator();
                Iterator j = other.iterator();
                for(/*i.first(),j.first()*/;i.hasNext() && j.hasNext() &&
                        i.next().equals(j.next()); /*i.next(), j.next()*/);
                return i.hasNext() && j.hasNext();
            }
        }
    }
