package solutions.pack1;
public class Dog_660019 {
    Breed b;
    int weight;
    
    public Dog_660019(Breed b, int w){
        this.b = b;
        this.weight = w;
    }
    public Breed getBreed(){
        return this.b;
    }
    public int getWeight(){
        return this.weight;
    }
    @Override
    public String toString() {
        return "Dog " + b + ", weight " + weight;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((b == null) ? 0 : b.hashCode());
        result = prime * result + weight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dog_660019 other = (Dog_660019) obj;
        if (b != other.b)
            return false;
        if (weight != other.weight)
            return false;
        return true;
    }
}

