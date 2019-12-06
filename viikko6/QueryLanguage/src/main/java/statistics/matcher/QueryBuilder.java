package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {

    List<Matcher> query;

    public QueryBuilder() {
        this.query = new ArrayList<>();
    }

    public Matcher build() {
        Matcher ret = new And(query.toArray(new Matcher[query.size()]));
        this.query.clear();
        return ret;
    }
    
    public QueryBuilder oneOf(Matcher... queries) {
        this.query.add(new Or(queries));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.query.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.query.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.query.add(new HasFewerThan(value, category));
        return this;
    }
}
