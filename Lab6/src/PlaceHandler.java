
import java.util.ArrayList;
import Interfaces.PlaceHandlerTemplate;
import Interfaces.PlaceTemplate;

public class PlaceHandler implements PlaceHandlerTemplate {
    ArrayList<PlaceTemplate> List;

    public PlaceHandler(){
        List = new ArrayList<PlaceTemplate>();
    }

    @Override
    public void AddPlace(PlaceTemplate place){
        List.add(place);
    }

    @Override
    public PlaceTemplate GetPlaceByName(String name){
        for(PlaceTemplate placeTemplate : List){
            if(placeTemplate.GetPlaceName() == name){
                return placeTemplate;
            }
        }
        return null;
    }

    @Override
    public String PrintAllPlaces(){
        String toPrint = "";
        for(PlaceTemplate placeTemplate : List){
            toPrint = toPrint.concat(placeTemplate.Print());
        }
        return toPrint;
    }
}
