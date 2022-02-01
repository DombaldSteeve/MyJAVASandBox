package com.diginamic.bibliorest.bibliorest.exceptions;

public class ErreurEmprunt extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErreurEmprunt()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public ErreurEmprunt(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ErreurEmprunt(String message,Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ErreurEmprunt(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ErreurEmprunt(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
