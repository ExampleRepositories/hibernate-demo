package com.bulain.hibernate.demo;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import com.bulain.hibernate.entity.Bike;
import com.bulain.hibernate.entity.Car;
import com.bulain.hibernate.entity.Vehicle;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
public class TableClassHierarchyTest extends HibernateTestCase {

    @Test
    public void testTableClassHierarchy() {
        Vehicle vechicle = new Vehicle();
        vechicle.setName("vechicle");

        Car car = new Car();
        car.setName("car");
        car.setCarInfo("carInfo");

        Bike bike = new Bike();
        bike.setName("bike");
        bike.setBikeInfo("bikeInfo");

        session.save(vechicle);
        session.save(car);
        session.save(bike);
        
        List<Vehicle> listVehicle = session.createCriteria(Vehicle.class).list();
        assertEquals(3, listVehicle.size());
        
        List<Car> listCar = session.createCriteria(Car.class).list();
        assertEquals(1, listCar.size());
        
        List<Bike> listBike = session.createCriteria(Bike.class).list();
        assertEquals(1, listBike.size());
    }

}
