package az.test.testtask.service;

import az.test.testtask.dto.UserDataRequest;
import az.test.testtask.entity.Data;
import az.test.testtask.exceptions.ExceptionEnums;
import az.test.testtask.utils.Checker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    static List<Data> data = new ArrayList<>();

    public List<Data> addData(UserDataRequest request) {
        Checker.throwIfNull(ExceptionEnums.getException(ExceptionEnums.INTERNAL_EXCEPTION), request);
        Checker.throwIfNull(ExceptionEnums.getException(ExceptionEnums.INVALID_REQUEST_DATA), request.getUserId(), request.getLevelId(), request.getResult());
        Checker.throwIfFalse(ExceptionEnums.getException(ExceptionEnums.INVALID_REQUEST_DATA), validateForInvalidIds(request));
        overwriteDuplicatedData(request);
        data.add(Data.mapper(request));
        return data;
    }

    public List<Data> getUserData(Long id) {
        return data
                .stream()
                .filter(o -> o.getUserId().equals(id))
                .sorted(Comparator.comparing(Data::getResult).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<Data> getLevelData(Long id) {
        return data
                .stream()
                .filter(o -> o.getLevelId().equals(id))
                .sorted(Comparator.comparing(Data::getResult).reversed())
                .limit(20)
                .collect(Collectors.toList());
    }

    private void overwriteDuplicatedData(UserDataRequest request) {
        Data duplicatedData = DataService
                .data
                .stream()
                .filter(o -> o.getLevelId().equals(request.getLevelId()) &&
                        o.getUserId().equals(request.getUserId()))
                .findFirst()
                .orElseGet(Data::new);
        data.remove(duplicatedData);
    }

    public boolean validateForInvalidIds(UserDataRequest request) {
        return data
                .stream()
                .anyMatch(o -> request.getLevelId() < 0 || request.getUserId() < 0);
    }

}
