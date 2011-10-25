package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bulain.hibernate.entity.CellPhone;
import com.bulain.hibernate.entity.Phone;
import com.bulain.hibernate.entity.TelPhone;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
public class TableConcreteClassTest extends HibernateTestCase {

    @Test
    public void testTableConcreteClass() {
        TelPhone telPhone = new TelPhone();
        telPhone.setName("telPhone");
        telPhone.setTelInfo("telInfo");

        CellPhone cellPhone = new CellPhone();
        cellPhone.setName("cellPhone");
        cellPhone.setCellInfo("cellInfo");

        session.save(telPhone);
        session.save(cellPhone);
        
        List<Phone> listPhone = session.createCriteria(Phone.class).list();
        assertEquals(2, listPhone.size());
        
        List<TelPhone> listTel = session.createCriteria(TelPhone.class).list();
        assertEquals(1, listTel.size());
        
        List<CellPhone> listCell = session.createCriteria(CellPhone.class).list();
        assertEquals(1, listCell.size());
    }

}
