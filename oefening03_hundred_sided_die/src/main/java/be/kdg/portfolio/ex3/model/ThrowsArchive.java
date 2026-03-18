package be.kdg.portfolio.ex3.model;
import be.kdg.portfolio.ex3.dao.DieThrow;
import be.kdg.portfolio.ex3.dao.ThrowsDao;

import java.util.List;
import java.util.stream.Collectors;

public class ThrowsArchive {
    private final ThrowsDao throwsDao;

    public ThrowsArchive() {
        this.throwsDao = new ThrowsDao();
    }

    public void addValueToArchive(MultiSidedDice dice) {
        int result = dice.getCurrentDiceValue();
        int min = dice.getDiceMinimum();
        int max = min + dice.getNumberOfSides() - 1;

        DieThrow newThrow = new DieThrow(result, min, max);
        throwsDao.create(newThrow);
    }

    public int getTotalNumberOfThrows() {
        return throwsDao.retrieveAll().size();
    }
    public List<DieThrow> getHistory() {
        return throwsDao.retrieveAll();
    }
    public void close() {
        throwsDao.close();
    }
}