package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    //create two Job objects using the empty constructor
    // use assertNotEquals to verify that the IDs of the two objects are distinct

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobA.getName() instanceof String);
        assertTrue(jobA.getEmployer() instanceof Employer);
        assertTrue(jobA.getLocation() instanceof Location);
        assertTrue(jobA.getPositionType() instanceof PositionType);
        assertTrue(jobA.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobA.getName(), "Product tester");
        assertEquals(jobA.getEmployer().getValue(), "ACME");
        assertEquals(jobA.getLocation().getValue(), "Desert");
        assertEquals(jobA.getPositionType().getValue(), "Quality control");
        assertEquals(jobA.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobB.equals(jobC));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobD = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobDString = jobD.toString();
        char firstCharacter = jobDString.charAt(0);
        char lastCharacter = jobDString.charAt(jobDString.length()-1);
        assertEquals(firstCharacter, '\n');
        assertEquals(lastCharacter, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobE = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobEString = jobE.toString();
        String testingString =
                "\n" +
                "ID: " + jobE.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(testingString, jobEString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobF = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String emptyField = "Data not available";
        String jobFString = jobF.toString();
        String testingString =
                "\n" +
                "ID: " + jobF.getId() + "\n" +
                "Name: " + emptyField + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + emptyField + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(testingString, jobFString);
    }
}





