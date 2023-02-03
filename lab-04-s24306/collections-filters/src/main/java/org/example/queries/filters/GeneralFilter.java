package main.java.org.example.queries.filters;

import main.java.org.example.model.Person;
import main.java.org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;

public class GeneralFilter implements IFilterPeople{
    private Predicate<SearchParameters> canFilterPredicate;
    private DualPredicate filterPredicate;

    public GeneralFilter(Predicate<SearchParameters> canFilterPredicate, DualPredicate filterPredicate){
        this.canFilterPredicate = canFilterPredicate;
        this.filterPredicate = filterPredicate;
    }

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
