package com.example.covid_19_app;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class CountryModel {
    private String flag,country,cases,todayCases,deaths,todayDeaths,recovered,active,critical;

    public CountryModel() {
    }

    public CountryModel(String flag, String country, String cases, String todayCases, String deaths, String todayDeaths, String recovered, String active, String critical) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Integer.parseInt(cases)).replaceAll("[.]"," ");

    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(todayCases)).replaceAll("[.]"," ");
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(deaths)).replaceAll("[.]"," ");
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(todayDeaths)).replaceAll("[.]"," ");
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(recovered)).replaceAll("[.]"," ");
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActive() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(active)).replaceAll("[.]"," ");
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCritical() {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(Double.parseDouble(critical)).replaceAll("[.]"," ");
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
