package main.java.org.example.queries.filters;

import main.java.org.example.model.Person;
import main.java.org.example.queries.search.SearchParameters;
import java.util.ArrayList;
import java.util.List;

public interface IFilterPeople {
    public void setSearchParameters(SearchParameters params);
    public boolean canFilter();
    public List<Person> filter(List<Person> list);
}
