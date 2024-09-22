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
//        String testString = job1.toString();
//        assertEquals(testString.charAt(0), System.lineSeparator());
//        assertEquals(testString.charAt(testString.length()), System.lineSeparator());
        assertTrue(job1.toString().startsWith(System.lineSeparator()));
        assertTrue(job1.toString().endsWith(System.lineSeparator()));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.toString().contains("ID: "));
        assertTrue(job1.toString().contains("Name: Product tester"));
        assertTrue(job1.toString().contains("Employer: ACME"));
        assertTrue(job1.toString().contains("Location: Desert"));
        assertTrue(job1.toString().contains("Position Type: Quality control"));
        assertTrue(job1.toString().contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job();
        assertTrue(job1.toString().contains("ID: "));
        assertTrue(job1.toString().contains("Name: Data not available"));
        assertTrue(job1.toString().contains("Employer: Data not available"));
        assertTrue(job1.toString().contains("Location: Data not available"));
        assertTrue(job1.toString().contains("Position Type: Data not available"));
        assertTrue(job1.toString().contains("Core Competency: Data not available"));
    }
}
