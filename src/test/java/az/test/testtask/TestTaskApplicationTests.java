package az.test.testtask;

import az.test.testtask.dto.UserDataRequest;
import az.test.testtask.entity.Data;
import az.test.testtask.service.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class TestTaskApplicationTests {

    private final DataService service = new DataService();


    @Test
    public void testAddData() {
        service.addData(mockData());
        Assertions.assertEquals(Data.mapper(mockData()), service.getLevelData(1L).get(0));
    }


    private UserDataRequest mockData() {
        return new UserDataRequest()
                .setLevelId(1L)
                .setUserId(2L)
                .setResult(10);
    }


}
