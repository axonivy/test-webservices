package ch.ivyteam.testservice.country.model;

import java.util.ArrayList;
import java.util.List;

public class Country
{
  public static List<Country> countries = new ArrayList<Country>();
  {
    countries.add(new Country("CH", "Switzerland"));
    countries.add(new Country("DE", "Germany"));
    countries.add(new Country("IT", "Italy"));
  }
  
  private String shortName;
  private String name;

  private Country(String shortName, String name)
  {
    this.setShortName(shortName);
    this.name = name;
  }

  public String getShortName()
  {
    return shortName;
  }

  public void setShortName(String shortName)
  {
    this.shortName = shortName;
  }
  
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

}
