package tacos.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.domain.Ingredient;
import tacos.web.repository.IngredientRepository;

@Component
public class IngrdientsConverter implements Converter<String, Ingredient> {

	@Autowired
	private IngredientRepository ingredientRepo;

	@Override
	public Ingredient convert(String source) {

		List<Ingredient> ingredients = new ArrayList<>();

		ingredientRepo.findAll().forEach(i -> ingredients.add(i));

		for (Ingredient ingredient : ingredients) {

			if (ingredient.getId().equalsIgnoreCase(source)) {
				return ingredient;
			}
		}

		return null;
	}
}
