package main.java.org.example.queries.filters;

import main.java.org.example.model.Person;
import main.java.org.example.queries.search.SearchParameters;

import java.util.List;

public class ByAgeFromFilter implements IFilterPeople{

    SearchParameters params;
    @Override
    public void setSearchParameters(SearchParameters params) {
        this.params = params;
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
