package org.datanucleus.test;

import java.util.*;
import org.junit.*;
import jakarta.persistence.*;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

public class App
{
	private String[] args;

	public static void main( String[] args ) throws Exception
	{
		new App( args ).run();
        }

        public App( String[] args )
        {
                this.args = args;
        }

        public void run() throws Exception
        {
		NucleusLogger.GENERAL.info(">> test START");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyTest");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
		    tx.begin();

		    Person p = new Person( 1l, "Fred" );
		    em.persist(p);
		    tx.commit();
		}
		catch (Throwable thr)
		{
		    NucleusLogger.GENERAL.error(">> Exception in test", thr);
		    fail("Failed test : " + thr.getMessage());
		}
		finally
		{
		    if (tx.isActive())
		    {
			tx.rollback();
		    }
		    em.close();
		}

		emf.close();
		NucleusLogger.GENERAL.info(">> test END");		
	}
}
