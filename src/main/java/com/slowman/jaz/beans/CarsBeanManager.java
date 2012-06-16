
package com.slowman.jaz.beans;

import com.slowman.jaz.domain.Car;
import com.slowman.jaz.ejb.CarsEJB;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class CarsBeanManager implements Serializable {
    
    private ListDataModel<Car> allCars = new ListDataModel<Car>();
    private Car car;
    
    @Inject
    private CarsEJB carsEJB;

    public String edit() {
        car = allCars.getRowData();
        return "edit";
    }
    
    public String show() {
        car = allCars.getRowData();
        return "show";
    }
    
    public String delete() {
        carsEJB.delete(allCars.getRowData());
        return "list";
    }
    
    public String update() {
        carsEJB.update(car);
        return "list";
    }
    
    public ListDataModel<Car> getAllCars() {
        allCars.setWrappedData(carsEJB.getAll());
        return allCars;
    }

    public Car getCar() {
        if(car == null) { 
            car = new Car(); 
        }
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
}
