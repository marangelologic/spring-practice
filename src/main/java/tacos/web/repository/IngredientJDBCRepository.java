package tacos.web.repository;

import tacos.domain.Ingredient;

public interface IngredientJDBCRepository {

	Iterable<Ingredient> findAll();

	Ingredient findOne(String id);

	Ingredient save(Ingredient ingredient);

}
