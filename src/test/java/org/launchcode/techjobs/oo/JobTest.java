package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public  void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.getName() instanceof String);
        assertEquals(job1.getName(), "Product tester");

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getEmployer().getValue(), "ACME");

        assertTrue(job1.getLocation() instanceof  Location);
        assertEquals(job1.getLocation().getValue(), "Desert");

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals(job1.getPositionType().getValue(), "Quality control");

        assertTrue(job1.getCoreCompetency() instanceof  CoreCompetency);
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        int length = job1.toString().length();

        assertEquals(job1.toString().substring(0,2), System.lineSeparator());
        assertEquals(job1.toString().substring(length - 2, length), System.lineSeparator());

        //assertTrue(job1.toString().startsWith(System.lineSeparator()));
        //assertTrue(job1.toString().endsWith(System.lineSeparator()));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] jobArray = job1.toString().split("\n");

        assertEquals(jobArray[1], "ID: " + job1.getId());
        assertEquals(jobArray[2], "Name: Product tester");
        assertEquals(jobArray[3], "Employer: ACME");
        assertEquals(jobArray[4], "Location: Desert");
        assertEquals(jobArray[5], "Position Type: Quality control");
        assertEquals(jobArray[6], "Core Competency: Persistence");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job();
        String[] jobArray = job1.toString().split("\n");

        assertEquals(jobArray[1], "ID: " + job1.getId());
        assertEquals(jobArray[2], "Name: Data not available");
        assertEquals(jobArray[3], "Employer: Data not available");
        assertEquals(jobArray[4], "Location: Data not available");
        assertEquals(jobArray[5], "Position Type: Data not available");
        assertEquals(jobArray[6], "Core Competency: Data not available");
    }
}
