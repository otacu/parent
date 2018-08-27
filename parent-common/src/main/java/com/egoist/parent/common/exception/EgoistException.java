package com.egoist.parent.common.exception;

/**
 *  自定义异常
 */
public class EgoistException extends Exception {
    /**
     * @Fields serialVersionUID : 自动生成serialVersionUID
     */
    private static final long serialVersionUID = -755458764669995111L;

    /**
     * 异常状态码
     */
    private int exceptionStatus = 0;

//	/**
//	 * 构造方法
//	 */
//	public EgoistException() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

    /**
     * @param message            错误信息
     * @param cause              异常
     * @param enableSuppression
     * @param writableStackTrace
     */
    public EgoistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message
     * @param cause
     */
    public EgoistException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public EgoistException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public EgoistException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message            错误信息
     * @param cause              异常
     * @param enableSuppression
     * @param writableStackTrace
     * @param exceptionStatus
     */
    public EgoistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int exceptionStatus) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionStatus = exceptionStatus;
    }

    /**
     * @param message
     * @param cause
     * @param exceptionStatus
     */
    public EgoistException(String message, Throwable cause, int exceptionStatus) {
        super(message, cause);
        this.exceptionStatus = exceptionStatus;
    }

    /**
     * @param message
     * @param exceptionStatus
     */
    public EgoistException(String message, int exceptionStatus) {
        super(message);
        this.exceptionStatus = exceptionStatus;
    }

    /**
     * @param cause
     * @param exceptionStatus
     */
    public EgoistException(Throwable cause, int exceptionStatus) {
        super(cause);
        this.exceptionStatus = exceptionStatus;
    }

    /**
     * @param exceptionStatus
     */
    public EgoistException(int exceptionStatus) {
        super("");
        this.exceptionStatus = exceptionStatus;
    }

    /**
     * @return the exceptionStatus
     */
    public int getExceptionStatus() {
        return exceptionStatus;
    }

    /**
     * @param exceptionStatus the exceptionStatus to set
     */
    public void setExceptionStatus(int exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }
}
