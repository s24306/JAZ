package main.java.org.example.queries.filters;

import main.java.org.example.model.Person;
import main.java.org.example.queries.search.SearchParameters;

import java.util.List;

public class ByAgeToFilter implements IFilterPeople{
    @Override
    public void setSearchParameters(SearchParameters params) {

    }

    @Override
    public boolean canFilter() {
        return false;
    }

    @Override
    public List<Person> filter(List<Person> list) {
        return null;
    }
}
