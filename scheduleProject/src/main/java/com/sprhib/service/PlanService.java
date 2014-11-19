package com.sprhib.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.sprhib.model.Plan;

public interface PlanService {

	
	public Date changeDateFormat(Date date);
	public Date changeStringIntoDate(String date);
    public int deletePlan(Plan plan);
}
