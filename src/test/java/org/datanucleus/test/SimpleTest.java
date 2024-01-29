package org.datanucleus.test;

import java.util.*;
import org.junit.*;
import jakarta.persistence.*;

import static org.junit.Assert.*;
import mydomain.model.*;
import org.datanucleus.util.NucleusLogger;

public class SimpleTest
{
    @Test
    public void testSimple()
    {
	try
	{
		String[] args = new String[0];
		App app = new App( args );
		app.run();
	}
	catch (Throwable thr)
	{
                    NucleusLogger.GENERAL.error(">> Exception in test", thr);
                    fail("Failed test : " + thr.getMessage());
	}
    }
}
