package edu.wctc.distjavazodiac.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wctc.distjavazodiac.entity.Month;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonMonthListService implements MonthListService {
    private List<Month> monthList;

    @Override
    public List<Month> getMonths() {
        return monthList;
    }

    @PostConstruct
    public void initMonths() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Month[] monthArray = mapper.readValue(Paths.get("months.json").toFile(), Month[].class);
            monthList = Arrays.asList(monthArray);
        } catch (IOException e) {
            e.printStackTrace();
            monthList = new ArrayList<>(0);
        }
    }
}
