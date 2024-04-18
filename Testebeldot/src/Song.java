public class Song implements Comparable<Song> {

    private String name;
    private Beat[] beats;


    public int admissible(){
        int nDrops=0, nBeats=0;
        for(Beat beat: beats){
            if(beat instanceof Drop)
                nDrops++;
            else nBeats++;
        }
        if(nDrops>=2&&nBeats>=3)
            return 1;
        return 0;
    }

    public int getIntensity(){
        int intensity = 0;
        for(Beat beat: beats){
            if(beat instanceof Drop){
                intensity += ((Drop) beat).getIntensity().ordinal();
            }
        }
        return intensity;
    }
    @Override
    public int compareTo(Song other){
        return Integer.compare(this.getIntensity(),other.getIntensity());
    }
}
