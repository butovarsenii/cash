package ru.crystals.loyal.providers.set.filters;

import ru.crystals.discounts.AdvertisingActionEntity;

/**
 * Данный фильтр "признает" только те РА, что суммируются всегда.
 * 
 * @author aperevozchikov
 */
public class WorksAnyTimeSetActionsFilter implements SetActionsFilter {

    @Override
    public boolean apply(AdvertisingActionEntity action) {
        boolean result = true;

        if (action == null) {
            return false;
        }
        
        result = Boolean.TRUE.equals(action.getWorksAnytime());

        return result;
    }

    @Override
    public String toString() {
        return String.format("works-any-time-set-actions-filter");
    }
    
}