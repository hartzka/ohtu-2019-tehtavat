package statistics.matcher;

public class QueryBuilder {
    Pino query;

    public QueryBuilder() {
        query = new Pino();
    }

    public Pino build() {
        return query;
    }

    public QueryBuilder playsIn(String team) {
        this.query = new PlaysIn(query, team);
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.query = new HasAtLeast(query, value, category);
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.query = new HasFewerThan(query, value, category);
        return this;
    }
}
