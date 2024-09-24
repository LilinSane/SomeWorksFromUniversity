package validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("RValidator")
public class RValidator extends AbstractValidator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        float x = (float) o;
        throw new ValidatorException(createMessage("Значение числа R должно быть заполнено"));
    }
}