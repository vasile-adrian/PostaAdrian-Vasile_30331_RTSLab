package Interfaces;

public interface PlaceHandlerTemplate {
    public void AddPlace(PlaceTemplate place);

    public PlaceTemplate GetPlaceByName(String name);

    public String PrintAllPlaces();
}
