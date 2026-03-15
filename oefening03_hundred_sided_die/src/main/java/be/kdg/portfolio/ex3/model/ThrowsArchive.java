package be.kdg.portfolio.ex3.model;
import be.kdg.portfolio.ex3.dao.DieThrow;
import be.kdg.portfolio.ex3.dao.ThrowsDao;

import java.util.List;
import java.util.stream.Collectors;

public class ThrowsArchive {
    // We vervangen de Collection door de DAO
    private final ThrowsDao throwsDao;

    public ThrowsArchive() {
        // Initialiseer de DAO (die op zijn beurt de DB-connectie opent)
        this.throwsDao = new ThrowsDao();
    }

    public void addValueToArchive(MultiSidedDice dice) {
        // Maak een nieuw DieThrow object aan met de gegevens van de huidige worp
        int result = dice.getCurrentDiceValue();
        int min = dice.getDiceMinimum();
        int max = min + dice.getNumberOfSides() - 1;

        DieThrow newThrow = new DieThrow(result, min, max);

        // Sla de worp op in de database via de DAO
        throwsDao.create(newThrow);
    }

    public int getTotalNumberOfThrows() {
        // Haal alle records op en tel ze
        return throwsDao.retrieveAll().size();
    }

    // Handig voor het overzichtsscherm in JavaFX
    public List<DieThrow> getHistory() {
        return throwsDao.retrieveAll();
    }

    // Vergeet deze niet aan te roepen bij het afsluiten van de app!
    public void close() {
        throwsDao.close();
    }

    @Override
    public String toString() {
        // Zet alle worpen uit de database om naar één grote String
        return throwsDao.retrieveAll().stream()
                .map(DieThrow::toString)
                .collect(Collectors.joining("\n"));
    }
}