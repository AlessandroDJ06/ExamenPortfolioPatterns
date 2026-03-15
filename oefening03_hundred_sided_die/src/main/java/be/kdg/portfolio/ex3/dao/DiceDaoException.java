package be.kdg.portfolio.ex3.dao;

public class DiceDaoException extends RuntimeException {
    public DiceDaoException(String message) {
        super(message);
    }

    public DiceDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
