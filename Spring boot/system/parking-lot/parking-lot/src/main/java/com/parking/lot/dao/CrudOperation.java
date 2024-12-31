package com.parking.lot.dao;


/**
 * All common CRUD operation method (R) for return type (T) for param type
 */
public interface CrudOperation<R,T> {
    /**
     * Save Object to database
     *
     * @param newObject
     * @return
     */
    R save(T newObject);

    /**
     * Get object using id
     *
     * @param id
     * @return
     */
    R getById(Integer id);

    /**
     * Update data into database and return R and new Object T
     *
     * @param newObject
     * @return
     */
    R update(T newObject);
}
