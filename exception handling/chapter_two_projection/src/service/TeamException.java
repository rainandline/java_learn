package service;

/**
 * 自定义异常
 */

public class TeamException extends Exception{
    private final long serialVersionUID = -3387529948L;
    public TeamException(){
        super();
    }

    public TeamException(String message){
        super(message);
    }

}
