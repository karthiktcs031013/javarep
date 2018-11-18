package com.gojek.parkinglot.park;

import com.gojek.parkinglot.command.BaseExecutor;
import com.gojek.parkinglot.command.CreateParkingLotExecutor;
import com.gojek.parkinglot.command.TestData;
import com.gojek.parkinglot.model.ParkinglotVO;
import com.gojek.parkinglot.validation.BaseValidation;
import com.gojek.parkinglot.validation.CreateParkingLotValidation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ParkingLotTemplateTest {


    @Test
    public void testValidCreateCommandTest() {
        BaseExecutor baseExecutor = Mockito.mock(CreateParkingLotExecutor.class);
        BaseValidation baseValidation = Mockito.mock(CreateParkingLotValidation.class);
        ParkingLotTemplate parkingLotTemplate = new ParkingLotTemplate(baseExecutor,baseValidation);

        Mockito.when(baseExecutor.execute(Mockito.anyString(),Mockito.any())).thenReturn(TestData.createPark());
        ParkinglotVO parkinglotVO = parkingLotTemplate.parkVehicle("create_parking_lot 6",null);
        Assert.assertNotNull(parkinglotVO);
        Assert.assertEquals(6, parkinglotVO.getParkingSlots().size());
    }
}
