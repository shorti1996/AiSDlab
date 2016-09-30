package lab08;

/**
 * Created by shorti1996 on 19.04.2016.
 */
public class DuplicateItemException extends RuntimeException {

    public DuplicateItemException(){
        super();
    }

    public DuplicateItemException(String s) {
        super(s);
    }
}
