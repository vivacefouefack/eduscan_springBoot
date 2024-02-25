/*package enetAfrica.eduScan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountExecutiveTest {

    @Test
    public void testAccountExecutiveConstructor() {
        AccountExecutive accountExecutive = new AccountExecutive();
        assertNotNull(accountExecutive);
        assertEquals(0, accountExecutive.getId());
        assertEquals(null, accountExecutive.getFirstName());
        assertEquals(null, accountExecutive.getLastName());
        assertEquals(null, accountExecutive.getPhoneNumber());
        assertEquals(null, accountExecutive.getProspectingZone());
        assertEquals(null, accountExecutive.getProspectingMunicipality());
        assertEquals(null, accountExecutive.getPhoto());
        assertEquals(0, accountExecutive.getSuperiorN1());
        assertEquals(0, accountExecutive.getSuperiorN2());
        assertEquals(0, accountExecutive.getSuperiorN3());
        assertEquals(null, accountExecutive.getAgendas());
        assertEquals(null, accountExecutive.getVisits());
    }

    @Test
    public void testAccountExecutiveSettersAndGetters() {
        AccountExecutive accountExecutive = new AccountExecutive();
        accountExecutive.setId(1);
        accountExecutive.setFirstName("Nelson");
        accountExecutive.setLastName("Madiba");
        accountExecutive.setPhoneNumber("123456789");
        accountExecutive.setProspectingZone("Riviera");
        accountExecutive.setProspectingMunicipality("Cocody");
        accountExecutive.setPhoto("src/image/photo1.jpg");
        accountExecutive.setSuperiorN1(1);
        accountExecutive.setSuperiorN2(2);
        accountExecutive.setSuperiorN3(3);
        assertEquals(1, accountExecutive.getId());
        assertEquals("Nelson", accountExecutive.getFirstName());
        assertEquals("Madiba", accountExecutive.getLastName());
        assertEquals("123456789", accountExecutive.getPhoneNumber());
        assertEquals("Riviera", accountExecutive.getProspectingZone());
        assertEquals("Cocody", accountExecutive.getProspectingMunicipality());
        assertEquals("src/image/photo1.jpg", accountExecutive.getPhoto());
        assertEquals(1, accountExecutive.getSuperiorN1());
        assertEquals(2, accountExecutive.getSuperiorN2());
        assertEquals(3, accountExecutive.getSuperiorN3());
    }

    @Test
    public void testAccountExecutiveNotEqual() {
        AccountExecutive accountExecutive1 = new AccountExecutive();
        accountExecutive1.setId(15);
        AccountExecutive accountExecutive2 = new AccountExecutive();
        accountExecutive2.setId(25);
        assertNotEquals(accountExecutive1, accountExecutive2);
    }

    @Test
    public void testAccountExecutiveAgenda() {
        AccountExecutive accountExecutive = new AccountExecutive();
        Set<Agenda> agendas = new HashSet<>();
        agendas.add(new Agenda());
        accountExecutive.setAgendas(agendas);
        assertEquals(agendas, accountExecutive.getAgendas());
    }

    @Test
    public void testAccountExecutiveVisit() {
        AccountExecutive accountExecutive = new AccountExecutive();
        Set<Visit> visits = new HashSet<>();
        visits.add(new Visit());
        accountExecutive.setVisits(visits);
        assertEquals(visits, accountExecutive.getVisits());
    }
}*/
