package validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("XValidator")
public class XValidator extends AbstractValidator{

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            float x = (float) o;
            float min = -4;
            float max = 4;
            if(x < min || x > max)
                throw new RuntimeException();
        } catch (NullPointerException e) {
            throw new ValidatorException(createMessage("Значение координаты Х должно быть заполнено"));
        }catch (RuntimeException e) {
            throw new ValidatorException(createMessage("Значение координаты Х должно входить в область определения"));
        }


    }
}
