package main.java.org.example.queries;

import main.java.org.example.model.Person;
import main.java.org.example.queries.filters.IFilterPeople;
import main.java.org.example.queries.results.Results;
import main.java.org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    private List<IFilterPeople> filters = new ArrayList<>();

    public Results GetResults(SearchParameters parameters, List<Person> data){
        return null;
    }

    public QueryProcessor addFilter(IFilterPeople filter){
        this.filters.add(filter);
        return this;
    }
}
