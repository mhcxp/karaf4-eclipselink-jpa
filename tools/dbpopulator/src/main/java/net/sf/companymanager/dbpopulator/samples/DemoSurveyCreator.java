package net.sf.companymanager.dbpopulator.samples;

import net.sf.companymanager.dto.QuestionDTO;
import net.sf.companymanager.dto.SectionDTO;
import net.sf.companymanager.dto.QuestionOptionDTO;
import net.sf.companymanager.dto.QuestionnaireDefinitionDTO;
import net.sf.companymanager.dto.SubquestionDTO;
import net.sf.companymanager.dto.embeddables.QuestionLanguageSettingsDTO;
import net.sf.companymanager.dto.embeddables.QuestionOptionLanguageSettingsDTO;
import net.sf.companymanager.dto.embeddables.QuestionnaireDefinitionLanguageSettingsDTO;
import net.sf.companymanager.dto.embeddables.SectionLanguageSettingsDTO;
import net.sf.companymanager.dto.support.TranslationDTO;
import net.sf.companymanager.facades.QuestionnaireDefinitionEditorFacade;
import net.sf.companymanager.types.Language;
import net.sf.companymanager.types.QuestionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoSurveyCreator {

    @Autowired
    private QuestionnaireDefinitionEditorFacade questionnaireDefinitionEditorFacade;

    public QuestionnaireDefinitionDTO create() {
        QuestionnaireDefinitionDTO survey = QuestionnaireDefinitionDTO
                .with()
                .language(Language.EN)
                .questionnairLanguageSettingsStart()
                .title("Sample QuestionnaireDefinition")
                .description(
                        "<p>This is a <strong><em>sample questionnaireDefinition</em></strong> designed for testing companymanagerSurvey.</p>")
                .welcomeText("Thank you for taking the time to participate in this questionnaireDefinition.")
                .questionnairLanguageSettingsEnd().build();
        survey = questionnaireDefinitionEditorFacade.save(survey);

        TranslationDTO<QuestionnaireDefinitionDTO, QuestionnaireDefinitionLanguageSettingsDTO> surveyTranslation = new TranslationDTO<>();
        surveyTranslation.setLanguage(Language.ES);
        surveyTranslation.setLanguageSettings(QuestionnaireDefinitionLanguageSettingsDTO.with()
                .title("Ejemplo de encuesta")
                .description("<p>Esto es una encuesta de ejemplo diseñada para companymanagerSurvey</p>")
                .welcomeText("Gracias por participar en esta encuesta").build());
        surveyTranslation.setTranslatedEntity(survey);

        questionnaireDefinitionEditorFacade.saveQuestionnaireTranslation(surveyTranslation);

        // Page 1
        SectionDTO section1 = SectionDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Section 1").pageLanguageSettingsEnd().randomizationEnabled(false).build();

        survey.addSection(section1);
        survey = questionnaireDefinitionEditorFacade.save(survey);

        section1 = survey.getLastSectionDTO();

        TranslationDTO<SectionDTO, SectionLanguageSettingsDTO> sectionTranslation = new TranslationDTO<>();
        sectionTranslation.setLanguage(Language.ES);
        sectionTranslation.setLanguageSettings(SectionLanguageSettingsDTO.with().title("Grupo 1").build());
        sectionTranslation.setTranslatedEntity(section1);
        questionnaireDefinitionEditorFacade.saveSectionTranslation(sectionTranslation);

        // Page 2
        SectionDTO section2 = SectionDTO.with().language(Language.EN).pageLanguageSettingsStart()
                .title("Section 2").pageLanguageSettingsEnd().randomizationEnabled(false).build();

        survey.addSection(section2);
        survey = questionnaireDefinitionEditorFacade.save(survey);
        section2 = survey.getLastSectionDTO();

        sectionTranslation = new TranslationDTO<>();
        sectionTranslation.setLanguage(Language.ES);
        sectionTranslation.setLanguageSettings(SectionLanguageSettingsDTO.with().title("Grupo 2").build());
        sectionTranslation.setTranslatedEntity(section2);
        questionnaireDefinitionEditorFacade.saveSectionTranslation(sectionTranslation);

        // Page 3
        SectionDTO section3 = SectionDTO.with().language(Language.EN).randomizationEnabled(false)
                .pageLanguageSettingsStart().title("Section 3").pageLanguageSettingsEnd().build();

        survey.addSection(section3);
        survey = questionnaireDefinitionEditorFacade.save(survey);
        section3 = survey.getLastSectionDTO();

        sectionTranslation = new TranslationDTO<>();
        sectionTranslation.setLanguage(Language.ES);
        sectionTranslation.setLanguageSettings(SectionLanguageSettingsDTO.with().title("Grupo 3").build());
        sectionTranslation.setTranslatedEntity(section3);
        questionnaireDefinitionEditorFacade.saveSectionTranslation(sectionTranslation);

        // 1 Single Textbox
        QuestionDTO question = QuestionDTO.with().type(QuestionType.S).language(Language.EN).code("Q1")
                .languageSettingsStart().title("What is your name?").languageSettingsEnd().required(true).build();
        section1.addQuestion(question);
        section1 = questionnaireDefinitionEditorFacade.save(section1);
        question = section1.getLastQuestionDTO();

        TranslationDTO<QuestionDTO, QuestionLanguageSettingsDTO> questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with().title("¿Cómo te llamas?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnaireDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 2 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q2").languageSettingsStart()
                .title("What is your age group?").languageSettingsEnd().required(true).build();

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("0-18 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("19-26 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("27-40 years")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("40 and over")
                .build());

        section1.addQuestion(question);
        section1 = questionnaireDefinitionEditorFacade.save(section1);
        question = section1.getLastQuestionDTO();

        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with().title("¿Cuál es su grupo de edad?")
                .build());
        questionTranslation.setTranslatedEntity(question);
        questionnaireDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        TranslationDTO<QuestionOptionDTO, QuestionOptionLanguageSettingsDTO> questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("0-18 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(0));
        questionnaireDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("19-26 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(1));
        questionnaireDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("27-40 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(2));
        questionnaireDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        questionOptionTranslation = new TranslationDTO<>();
        questionOptionTranslation.setLanguage(Language.ES);
        questionOptionTranslation.setLanguageSettings(QuestionOptionLanguageSettingsDTO.with().title("Más de 40 años")
                .build());
        questionOptionTranslation.setTranslatedEntity(question.getQuestionOptions().get(3));
        questionnaireDefinitionEditorFacade.saveQuestionOptionTranslation(questionOptionTranslation);

        // 3 Numeric
        question = QuestionDTO.with().type(QuestionType.N).language(Language.EN).code("Q3").languageSettingsStart()
                .title("And for our records, specifically how old are you?").languageSettingsEnd().required(true)
                .build();

        section1.addQuestion(question);
        section1 = questionnaireDefinitionEditorFacade.save(section1);

        question = section1.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("¿Qué edad tienes exactamente?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnaireDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 4 Comment/Essay Box
        question = QuestionDTO.with().type(QuestionType.T).language(Language.EN).code("Q4").languageSettingsStart()
                .title("Please tell us a little about yourself. What was your first job, and did you enjoy it?")
                .languageSettingsEnd().required(true).build();

        section2.addQuestion(question);
        section2 = questionnaireDefinitionEditorFacade.save(section2);

        question = section2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("Cuentanos un poco sobre ti. ¿Cuál fue tu primer trabajo?, ¿era divertido?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnaireDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 5 List (Radio) Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).language(Language.EN).code("Q5").languageSettingsStart()
                .title("Given your extraordinary age, how do you find using this questionnaireDefinition tool?")
                .languageSettingsEnd().required(true).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN)
                .title("Very difficult to read, my eyesight is dim").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN)
                .title("Easy, my carer is doing it all for me").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("How <b><i>dare</i></b> you insult me like that! I'm YOUNG").build());

        section2.addQuestion(question);
        section2 = questionnaireDefinitionEditorFacade.save(section2);

        question = section2.getLastQuestionDTO();
        questionTranslation = new TranslationDTO<>();
        questionTranslation.setLanguage(Language.ES);
        questionTranslation.setLanguageSettings(QuestionLanguageSettingsDTO.with()
                .title("Dada tu extraodinaria edad, ¿Qué opinas de esta herramienta?").build());
        questionTranslation.setTranslatedEntity(question);
        questionnaireDefinitionEditorFacade.saveQuestionTranslation(questionTranslation);

        // 6 Multiple Choice (Only One QuestionOption)
        question = QuestionDTO.with().type(QuestionType.L).code("Q6").language(Language.EN).languageSettingsStart()
                .title("Which of these ads makes you want to find out more?").languageSettingsEnd().required(true)
                .build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Ad one").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Ad two").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Ad three").build());

        section2.addQuestion(question);
        section2 = questionnaireDefinitionEditorFacade.save(section2);

        // 7 Rating Scale (Agree-Disagree) Array Flexible
        question = QuestionDTO
                .with()
                .type(QuestionType.F)
                .code("Q7")
                .language(Language.EN)
                .languageSettingsStart()
                .title("Please have a good look at this ad, and then complete the questions below.<br /><img src='http://www.aptigence.com.au/images/lawyer1.jpg' border='1'>")
                .languageSettingsEnd().required(true).build();

        question.addSubquestion(SubquestionDTO.with().code("Q7.1").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad suggests the lawyer is on my side, not his own")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.2").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart()
                .title("This ad suggests that the lawyer is interested in a life of frugal community service")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.3").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad would be enough to get me to hire this lawyer")
                .languageSettingsEnd().build());
        question.addSubquestion(SubquestionDTO.with().code("Q7.4").language(Language.EN).type(QuestionType.L)
                .languageSettingsStart().title("This ad gives me confidence in the lawyers experience")
                .languageSettingsEnd().build());

        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Agree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN)
                .title("Neither agree nor disagree").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Disagree somewhat")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O5").language(Language.EN).title("Agree strongly")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O6").language(Language.EN).title("Disagree strongly")
                .build());

        section3.addQuestion(question);
        section3 = questionnaireDefinitionEditorFacade.save(section3);

        // 8. List checkbox - Multiple_Answers
        question = QuestionDTO.with().type(QuestionType.M).code("Q8").language(Language.EN).languageSettingsStart()
                .title("What flavors of ice cream do you like?. Choose all that apply.").languageSettingsEnd()
                .required(false).build();
        question.addQuestionOption(QuestionOptionDTO.with().code("O1").language(Language.EN).title("Vanilla").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O2").language(Language.EN).title("Chocolate").build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O3").language(Language.EN).title("Strawberry")
                .build());
        question.addQuestionOption(QuestionOptionDTO.with().code("O4").language(Language.EN).title("Pistachio").build());

        section3.addQuestion(question);
        section3 = questionnaireDefinitionEditorFacade.save(section3);

        return survey;
    }
}
