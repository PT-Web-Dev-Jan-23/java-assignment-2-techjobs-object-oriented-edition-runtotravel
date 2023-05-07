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
        Job jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobFour = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobThree.equals(jobFour));
    }
}



