/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis;

import java.util.*;
import org.dresdenocl.ocl2parser.testcasegenerator.gen.testcasegenerator.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node) { defaultIn(node); }
    public void outStart(Start node) { defaultOut(node); }
    public void defaultIn(Node node) { }
    public void defaultOut(Node node) { }
    
    public void caseStart(Start node) {
        inStart(node);
        node.getPTestpackage().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inASuiteTestpackage(ASuiteTestpackage node) { defaultIn(node); }
    public void outASuiteTestpackage(ASuiteTestpackage node) { defaultOut(node); }

    public void caseASuiteTestpackage(ASuiteTestpackage node) {
        inASuiteTestpackage(node);
        if(node.getTestsuite() != null) {
            node.getTestsuite().apply(this);
        }
        outASuiteTestpackage(node);
    }

    public void inATestcaseTestpackage(ATestcaseTestpackage node) { defaultIn(node); }
    public void outATestcaseTestpackage(ATestcaseTestpackage node) { defaultOut(node); }

    public void caseATestcaseTestpackage(ATestcaseTestpackage node) {
        inATestcaseTestpackage(node);
        if(node.getTestcasefile() != null) {
            node.getTestcasefile().apply(this);
        }
        outATestcaseTestpackage(node);
    }

    public void inATestsuite(ATestsuite node) { defaultIn(node); }
    public void outATestsuite(ATestsuite node) { defaultOut(node); }

    public void caseATestsuite(ATestsuite node) {
        inATestsuite(node);
        if(node.getNames() != null) {
            node.getNames().apply(this);
        }
        if(node.getPackageDeclaration() != null) {
            node.getPackageDeclaration().apply(this);
        }
        {
            Object temp[] = node.getSuiteElement().toArray();
            for(int i = 0; i < temp.length; i++) {
                ((PSuiteElement) temp[i]).apply(this);
            }
        }
        outATestsuite(node);
    }

    public void inANames(ANames node) { defaultIn(node); }
    public void outANames(ANames node) { defaultOut(node); }

    public void caseANames(ANames node) {
        inANames(node);
        if(node.getSuitename() != null) {
            node.getSuitename().apply(this);
        }
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        outANames(node);
    }

    public void inASuiteElement(ASuiteElement node) { defaultIn(node); }
    public void outASuiteElement(ASuiteElement node) { defaultOut(node); }

    public void caseASuiteElement(ASuiteElement node) {
        inASuiteElement(node);
        if(node.getInclude() != null) {
            node.getInclude().apply(this);
        }
        if(node.getOpenparen() != null) {
            node.getOpenparen().apply(this);
        }
        if(node.getFirst() != null) {
            node.getFirst().apply(this);
        }
        if(node.getStringLiteral() != null) {
            node.getStringLiteral().apply(this);
        }
        if(node.getLast() != null) {
            node.getLast().apply(this);
        }
        if(node.getCloseparen() != null) {
            node.getCloseparen().apply(this);
        }
        outASuiteElement(node);
    }

    public void inATestcasefile(ATestcasefile node) { defaultIn(node); }
    public void outATestcasefile(ATestcasefile node) { defaultOut(node); }

    public void caseATestcasefile(ATestcasefile node) {
        inATestcasefile(node);
        if(node.getName() != null) {
            node.getName().apply(this);
        }
        if(node.getPackageDeclaration() != null) {
            node.getPackageDeclaration().apply(this);
        }
        if(node.getModelDeclaration() != null) {
            node.getModelDeclaration().apply(this);
        }
        {
            Object temp[] = node.getTestcaseElement().toArray();
            for(int i = 0; i < temp.length; i++) {
                ((PTestcaseElement) temp[i]).apply(this);
            }
        }
        outATestcasefile(node);
    }

    public void inAName(AName node) { defaultIn(node); }
    public void outAName(AName node) { defaultOut(node); }

    public void caseAName(AName node) {
        inAName(node);
        if(node.getTestname() != null) {
            node.getTestname().apply(this);
        }
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        outAName(node);
    }

    public void inAPackageDeclaration(APackageDeclaration node) { defaultIn(node); }
    public void outAPackageDeclaration(APackageDeclaration node) { defaultOut(node); }

    public void caseAPackageDeclaration(APackageDeclaration node) {
        inAPackageDeclaration(node);
        if(node.getPackage() != null) {
            node.getPackage().apply(this);
        }
        if(node.getPackageName() != null) {
            node.getPackageName().apply(this);
        }
        outAPackageDeclaration(node);
    }

    public void inAMetamodelModelDeclaration(AMetamodelModelDeclaration node) { defaultIn(node); }
    public void outAMetamodelModelDeclaration(AMetamodelModelDeclaration node) { defaultOut(node); }

    public void caseAMetamodelModelDeclaration(AMetamodelModelDeclaration node) {
        inAMetamodelModelDeclaration(node);
        if(node.getMetamodelDesc() != null) {
            node.getMetamodelDesc().apply(this);
        }
        if(node.getModelDesc() != null) {
            node.getModelDesc().apply(this);
        }
        outAMetamodelModelDeclaration(node);
    }

    public void inAModelModelDeclaration(AModelModelDeclaration node) { defaultIn(node); }
    public void outAModelModelDeclaration(AModelModelDeclaration node) { defaultOut(node); }

    public void caseAModelModelDeclaration(AModelModelDeclaration node) {
        inAModelModelDeclaration(node);
        if(node.getModelDesc() != null) {
            node.getModelDesc().apply(this);
        }
        if(node.getMetamodelDesc() != null) {
            node.getMetamodelDesc().apply(this);
        }
        outAModelModelDeclaration(node);
    }

    public void inAMetamodelDesc(AMetamodelDesc node) { defaultIn(node); }
    public void outAMetamodelDesc(AMetamodelDesc node) { defaultOut(node); }

    public void caseAMetamodelDesc(AMetamodelDesc node) {
        inAMetamodelDesc(node);
        if(node.getMetamodel() != null) {
            node.getMetamodel().apply(this);
        }
        if(node.getPackageName() != null) {
            node.getPackageName().apply(this);
        }
        outAMetamodelDesc(node);
    }

    public void inAModelDesc(AModelDesc node) { defaultIn(node); }
    public void outAModelDesc(AModelDesc node) { defaultOut(node); }

    public void caseAModelDesc(AModelDesc node) {
        inAModelDesc(node);
        if(node.getModel() != null) {
            node.getModel().apply(this);
        }
        if(node.getFirst() != null) {
            node.getFirst().apply(this);
        }
        if(node.getStringLiteral() != null) {
            node.getStringLiteral().apply(this);
        }
        if(node.getLast() != null) {
            node.getLast().apply(this);
        }
        outAModelDesc(node);
    }

    public void inATestcaseElement(ATestcaseElement node) { defaultIn(node); }
    public void outATestcaseElement(ATestcaseElement node) { defaultOut(node); }

    public void caseATestcaseElement(ATestcaseElement node) {
        inATestcaseElement(node);
        if(node.getTestcasename() != null) {
            node.getTestcasename().apply(this);
        }
        if(node.getBraceOpen() != null) {
            node.getBraceOpen().apply(this);
        }
        if(node.getOclExpression() != null) {
            node.getOclExpression().apply(this);
        }
        if(node.getResult() != null) {
            node.getResult().apply(this);
        }
        if(node.getBraceClose() != null) {
            node.getBraceClose().apply(this);
        }
        outATestcaseElement(node);
    }

    public void inATestcasename(ATestcasename node) { defaultIn(node); }
    public void outATestcasename(ATestcasename node) { defaultOut(node); }

    public void caseATestcasename(ATestcasename node) {
        inATestcasename(node);
        if(node.getTestcase() != null) {
            node.getTestcase().apply(this);
        }
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        outATestcasename(node);
    }

    public void inAOclExpression(AOclExpression node) { defaultIn(node); }
    public void outAOclExpression(AOclExpression node) { defaultOut(node); }

    public void caseAOclExpression(AOclExpression node) {
        inAOclExpression(node);
        if(node.getOclexpression() != null) {
            node.getOclexpression().apply(this);
        }
        if(node.getOclblock() != null) {
            node.getOclblock().apply(this);
        }
        outAOclExpression(node);
    }

    public void inAAbstractmodelResult(AAbstractmodelResult node) { defaultIn(node); }
    public void outAAbstractmodelResult(AAbstractmodelResult node) { defaultOut(node); }

    public void caseAAbstractmodelResult(AAbstractmodelResult node) {
        inAAbstractmodelResult(node);
        if(node.getAbstractModel() != null) {
            node.getAbstractModel().apply(this);
        }
        outAAbstractmodelResult(node);
    }

    public void inAErrorResult(AErrorResult node) { defaultIn(node); }
    public void outAErrorResult(AErrorResult node) { defaultOut(node); }

    public void caseAErrorResult(AErrorResult node) {
        inAErrorResult(node);
        if(node.getError() != null) {
            node.getError().apply(this);
        }
        outAErrorResult(node);
    }

    public void inAAbstractModel(AAbstractModel node) { defaultIn(node); }
    public void outAAbstractModel(AAbstractModel node) { defaultOut(node); }

    public void caseAAbstractModel(AAbstractModel node) {
        inAAbstractModel(node);
        if(node.getAbstractmodel() != null) {
            node.getAbstractmodel().apply(this);
        }
        if(node.getBraceOpen() != null) {
            node.getBraceOpen().apply(this);
        }
        if(node.getFirstName() != null) {
            node.getFirstName().apply(this);
        }
        if(node.getAssign() != null) {
            node.getAssign().apply(this);
        }
        if(node.getModelExpression() != null) {
            node.getModelExpression().apply(this);
        }
        {
            Object temp[] = node.getAssignment().toArray();
            for(int i = 0; i < temp.length; i++) {
                ((PAssignment) temp[i]).apply(this);
            }
        }
        if(node.getBraceClose() != null) {
            node.getBraceClose().apply(this);
        }
        outAAbstractModel(node);
    }

    public void inAAssignment(AAssignment node) { defaultIn(node); }
    public void outAAssignment(AAssignment node) { defaultOut(node); }

    public void caseAAssignment(AAssignment node) {
        inAAssignment(node);
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        if(node.getAssign() != null) {
            node.getAssign().apply(this);
        }
        if(node.getModelExpression() != null) {
            node.getModelExpression().apply(this);
        }
        outAAssignment(node);
    }

    public void inAModelelementModelExpression(AModelelementModelExpression node) { defaultIn(node); }
    public void outAModelelementModelExpression(AModelelementModelExpression node) { defaultOut(node); }

    public void caseAModelelementModelExpression(AModelelementModelExpression node) {
        inAModelelementModelExpression(node);
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        if(node.getOpenparen() != null) {
            node.getOpenparen().apply(this);
        }
        if(node.getParameters() != null) {
            node.getParameters().apply(this);
        }
        if(node.getCloseparen() != null) {
            node.getCloseparen().apply(this);
        }
        if(node.getAtpre() != null) {
            node.getAtpre().apply(this);
        }
        outAModelelementModelExpression(node);
    }

    public void inAIdentModelExpression(AIdentModelExpression node) { defaultIn(node); }
    public void outAIdentModelExpression(AIdentModelExpression node) { defaultOut(node); }

    public void caseAIdentModelExpression(AIdentModelExpression node) {
        inAIdentModelExpression(node);
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        outAIdentModelExpression(node);
    }

    public void inANullModelExpression(ANullModelExpression node) { defaultIn(node); }
    public void outANullModelExpression(ANullModelExpression node) { defaultOut(node); }

    public void caseANullModelExpression(ANullModelExpression node) {
        inANullModelExpression(node);
        if(node.getNull() != null) {
            node.getNull().apply(this);
        }
        outANullModelExpression(node);
    }

    public void inASimpleModelExpression(ASimpleModelExpression node) { defaultIn(node); }
    public void outASimpleModelExpression(ASimpleModelExpression node) { defaultOut(node); }

    public void caseASimpleModelExpression(ASimpleModelExpression node) {
        inASimpleModelExpression(node);
        if(node.getSimpleExpression() != null) {
            node.getSimpleExpression().apply(this);
        }
        outASimpleModelExpression(node);
    }

    public void inANewModelExpression(ANewModelExpression node) { defaultIn(node); }
    public void outANewModelExpression(ANewModelExpression node) { defaultOut(node); }

    public void caseANewModelExpression(ANewModelExpression node) {
        inANewModelExpression(node);
        if(node.getNew() != null) {
            node.getNew().apply(this);
        }
        if(node.getIdent() != null) {
            node.getIdent().apply(this);
        }
        if(node.getOpenparen() != null) {
            node.getOpenparen().apply(this);
        }
        if(node.getParameters() != null) {
            node.getParameters().apply(this);
        }
        if(node.getCloseparen() != null) {
            node.getCloseparen().apply(this);
        }
        outANewModelExpression(node);
    }

    public void inARealSimpleExpression(ARealSimpleExpression node) { defaultIn(node); }
    public void outARealSimpleExpression(ARealSimpleExpression node) { defaultOut(node); }

    public void caseARealSimpleExpression(ARealSimpleExpression node) {
        inARealSimpleExpression(node);
        if(node.getRealValue() != null) {
            node.getRealValue().apply(this);
        }
        outARealSimpleExpression(node);
    }

    public void inAIntegerSimpleExpression(AIntegerSimpleExpression node) { defaultIn(node); }
    public void outAIntegerSimpleExpression(AIntegerSimpleExpression node) { defaultOut(node); }

    public void caseAIntegerSimpleExpression(AIntegerSimpleExpression node) {
        inAIntegerSimpleExpression(node);
        if(node.getIntegerValue() != null) {
            node.getIntegerValue().apply(this);
        }
        outAIntegerSimpleExpression(node);
    }

    public void inAStringSimpleExpression(AStringSimpleExpression node) { defaultIn(node); }
    public void outAStringSimpleExpression(AStringSimpleExpression node) { defaultOut(node); }

    public void caseAStringSimpleExpression(AStringSimpleExpression node) {
        inAStringSimpleExpression(node);
        if(node.getFirst() != null) {
            node.getFirst().apply(this);
        }
        if(node.getStringLiteral() != null) {
            node.getStringLiteral().apply(this);
        }
        if(node.getLast() != null) {
            node.getLast().apply(this);
        }
        outAStringSimpleExpression(node);
    }

    public void inAElementParameter(AElementParameter node) { defaultIn(node); }
    public void outAElementParameter(AElementParameter node) { defaultOut(node); }

    public void caseAElementParameter(AElementParameter node) {
        inAElementParameter(node);
        if(node.getComma() != null) {
            node.getComma().apply(this);
        }
        if(node.getParameter() != null) {
            node.getParameter().apply(this);
        }
        outAElementParameter(node);
    }

    public void inASingleParameters(ASingleParameters node) { defaultIn(node); }
    public void outASingleParameters(ASingleParameters node) { defaultOut(node); }

    public void caseASingleParameters(ASingleParameters node) {
        inASingleParameters(node);
        if(node.getParameter() != null) {
            node.getParameter().apply(this);
        }
        outASingleParameters(node);
    }

    public void inAMultipleParameters(AMultipleParameters node) { defaultIn(node); }
    public void outAMultipleParameters(AMultipleParameters node) { defaultOut(node); }

    public void caseAMultipleParameters(AMultipleParameters node) {
        inAMultipleParameters(node);
        if(node.getParameter() != null) {
            node.getParameter().apply(this);
        }
        if(node.getComma() != null) {
            node.getComma().apply(this);
        }
        if(node.getParameters() != null) {
            node.getParameters().apply(this);
        }
        outAMultipleParameters(node);
    }

    public void inAExpressionParameter(AExpressionParameter node) { defaultIn(node); }
    public void outAExpressionParameter(AExpressionParameter node) { defaultOut(node); }

    public void caseAExpressionParameter(AExpressionParameter node) {
        inAExpressionParameter(node);
        if(node.getModelExpression() != null) {
            node.getModelExpression().apply(this);
        }
        outAExpressionParameter(node);
    }
}
