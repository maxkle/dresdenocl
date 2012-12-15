/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.dresdenocl.language.ocl.resource.ocl.mopp;

public class OclReferenceResolverSwitch implements org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.PackageDeclarationNestedNamespaceCSNamespaceReferenceResolver packageDeclarationNestedNamespaceCSNamespaceReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.PackageDeclarationNestedNamespaceCSNamespaceReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.AttributeContextDeclarationCSPropertyReferenceResolver attributeContextDeclarationCSPropertyReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.AttributeContextDeclarationCSPropertyReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.OperationDefinitionCSOperationReferenceResolver operationDefinitionCSOperationReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.OperationDefinitionCSOperationReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.ParameterCSParameterReferenceResolver parameterCSParameterReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.ParameterCSParameterReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.OperationCallBaseExpCSOperationNameReferenceResolver operationCallBaseExpCSOperationNameReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.OperationCallBaseExpCSOperationNameReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.PropertyCallBaseExpCSPropertyReferenceResolver propertyCallBaseExpCSPropertyReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.PropertyCallBaseExpCSPropertyReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.TypePathNameSimpleCSTypeNameReferenceResolver typePathNameSimpleCSTypeNameReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.TypePathNameSimpleCSTypeNameReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.TypePathNameNestedCSNamespaceReferenceResolver typePathNameNestedCSNamespaceReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.TypePathNameNestedCSNamespaceReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.CollectionTypeIdentifierCSTypeNameReferenceResolver collectionTypeIdentifierCSTypeNameReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.CollectionTypeIdentifierCSTypeNameReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.StaticOperationCallExpCSOperationNameReferenceResolver staticOperationCallExpCSOperationNameReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.StaticOperationCallExpCSOperationNameReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.EnumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver enumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.EnumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver();
	protected org.dresdenocl.language.ocl.resource.ocl.analysis.NamedLiteralExpCSNamedElementReferenceResolver namedLiteralExpCSNamedElementReferenceResolver = new org.dresdenocl.language.ocl.resource.ocl.analysis.NamedLiteralExpCSNamedElementReferenceResolver();
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.PackageDeclarationNestedNamespaceCS, org.dresdenocl.pivotmodel.Namespace> getPackageDeclarationNestedNamespaceCSNamespaceReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPackageDeclarationNestedNamespaceCS_Namespace(), packageDeclarationNestedNamespaceCSNamespaceReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.AttributeContextDeclarationCS, org.dresdenocl.pivotmodel.Property> getAttributeContextDeclarationCSPropertyReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getAttributeContextDeclarationCS_Property(), attributeContextDeclarationCSPropertyReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.OperationDefinitionCS, org.dresdenocl.pivotmodel.Operation> getOperationDefinitionCSOperationReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationDefinitionCS_Operation(), operationDefinitionCSOperationReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.ParameterCS, org.dresdenocl.pivotmodel.Parameter> getParameterCSParameterReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getParameterCS_Parameter(), parameterCSParameterReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.OperationCallBaseExpCS, org.dresdenocl.pivotmodel.Operation> getOperationCallBaseExpCSOperationNameReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationCallBaseExpCS_OperationName(), operationCallBaseExpCSOperationNameReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.PropertyCallBaseExpCS, org.dresdenocl.pivotmodel.Property> getPropertyCallBaseExpCSPropertyReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPropertyCallBaseExpCS_Property(), propertyCallBaseExpCSPropertyReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.TypePathNameSimpleCS, org.dresdenocl.pivotmodel.Type> getTypePathNameSimpleCSTypeNameReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameSimpleCS_TypeName(), typePathNameSimpleCSTypeNameReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.TypePathNameNestedCS, org.dresdenocl.pivotmodel.Namespace> getTypePathNameNestedCSNamespaceReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameNestedCS_Namespace(), typePathNameNestedCSNamespaceReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.CollectionTypeIdentifierCS, org.dresdenocl.pivotmodel.Type> getCollectionTypeIdentifierCSTypeNameReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getCollectionTypeIdentifierCS_TypeName(), collectionTypeIdentifierCSTypeNameReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.StaticOperationCallExpCS, org.dresdenocl.pivotmodel.Operation> getStaticOperationCallExpCSOperationNameReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getStaticOperationCallExpCS_OperationName(), staticOperationCallExpCSOperationNameReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.EnumLiteralOrStaticPropertyExpCS, org.dresdenocl.pivotmodel.NamedElement> getEnumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getEnumLiteralOrStaticPropertyExpCS_EnumLiteralOrStaticProperty(), enumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver);
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<org.dresdenocl.language.ocl.NamedLiteralExpCS, org.dresdenocl.pivotmodel.NamedElement> getNamedLiteralExpCSNamedElementReferenceResolver() {
		return getResolverChain(org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getNamedLiteralExpCS_NamedElement(), namedLiteralExpCSNamedElementReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		packageDeclarationNestedNamespaceCSNamespaceReferenceResolver.setOptions(options);
		attributeContextDeclarationCSPropertyReferenceResolver.setOptions(options);
		operationDefinitionCSOperationReferenceResolver.setOptions(options);
		parameterCSParameterReferenceResolver.setOptions(options);
		operationCallBaseExpCSOperationNameReferenceResolver.setOptions(options);
		propertyCallBaseExpCSPropertyReferenceResolver.setOptions(options);
		typePathNameSimpleCSTypeNameReferenceResolver.setOptions(options);
		typePathNameNestedCSNamespaceReferenceResolver.setOptions(options);
		collectionTypeIdentifierCSTypeNameReferenceResolver.setOptions(options);
		staticOperationCallExpCSOperationNameReferenceResolver.setOptions(options);
		enumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver.setOptions(options);
		namedLiteralExpCSNamedElementReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPackageDeclarationNestedNamespaceCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Namespace> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Namespace>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("namespace")) {
				packageDeclarationNestedNamespaceCSNamespaceReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.PackageDeclarationNestedNamespaceCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getAttributeContextDeclarationCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Property> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				attributeContextDeclarationCSPropertyReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.AttributeContextDeclarationCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationDefinitionCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("operation")) {
				operationDefinitionCSOperationReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.OperationDefinitionCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getParameterCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Parameter> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Parameter>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("parameter")) {
				parameterCSParameterReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.ParameterCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationCallBaseExpCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("operationName")) {
				operationCallBaseExpCSOperationNameReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.OperationCallBaseExpCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPropertyCallBaseExpCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Property> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				propertyCallBaseExpCSPropertyReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.PropertyCallBaseExpCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameSimpleCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Type> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("typeName")) {
				typePathNameSimpleCSTypeNameReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.TypePathNameSimpleCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameNestedCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Namespace> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Namespace>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("namespace")) {
				typePathNameNestedCSNamespaceReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.TypePathNameNestedCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getCollectionTypeIdentifierCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Type> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("typeName")) {
				collectionTypeIdentifierCSTypeNameReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.CollectionTypeIdentifierCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getStaticOperationCallExpCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.Operation>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("operationName")) {
				staticOperationCallExpCSOperationNameReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.StaticOperationCallExpCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getEnumLiteralOrStaticPropertyExpCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.NamedElement> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.NamedElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("enumLiteralOrStaticProperty")) {
				enumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.EnumLiteralOrStaticPropertyExpCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getNamedLiteralExpCS().isInstance(container)) {
			OclFuzzyResolveResult<org.dresdenocl.pivotmodel.NamedElement> frr = new OclFuzzyResolveResult<org.dresdenocl.pivotmodel.NamedElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("namedElement")) {
				namedLiteralExpCSNamedElementReferenceResolver.resolve(identifier, (org.dresdenocl.language.ocl.NamedLiteralExpCS) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPackageDeclarationNestedNamespaceCS_Namespace()) {
			return getResolverChain(reference, packageDeclarationNestedNamespaceCSNamespaceReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getAttributeContextDeclarationCS_Property()) {
			return getResolverChain(reference, attributeContextDeclarationCSPropertyReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationDefinitionCS_Operation()) {
			return getResolverChain(reference, operationDefinitionCSOperationReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getParameterCS_Parameter()) {
			return getResolverChain(reference, parameterCSParameterReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getOperationCallBaseExpCS_OperationName()) {
			return getResolverChain(reference, operationCallBaseExpCSOperationNameReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getPropertyCallBaseExpCS_Property()) {
			return getResolverChain(reference, propertyCallBaseExpCSPropertyReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameSimpleCS_TypeName()) {
			return getResolverChain(reference, typePathNameSimpleCSTypeNameReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getTypePathNameNestedCS_Namespace()) {
			return getResolverChain(reference, typePathNameNestedCSNamespaceReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getCollectionTypeIdentifierCS_TypeName()) {
			return getResolverChain(reference, collectionTypeIdentifierCSTypeNameReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getStaticOperationCallExpCS_OperationName()) {
			return getResolverChain(reference, staticOperationCallExpCSOperationNameReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getEnumLiteralOrStaticPropertyExpCS_EnumLiteralOrStaticProperty()) {
			return getResolverChain(reference, enumLiteralOrStaticPropertyExpCSEnumLiteralOrStaticPropertyReferenceResolver);
		}
		if (reference == org.dresdenocl.language.ocl.OclPackage.eINSTANCE.getNamedLiteralExpCS_NamedElement()) {
			return getResolverChain(reference, namedLiteralExpCSNamedElementReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.dresdenocl.language.ocl.resource.ocl.IOclOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.dresdenocl.language.ocl.resource.ocl.util.OclRuntimeUtil().logWarning("Found value with invalid type for option " + org.dresdenocl.language.ocl.resource.ocl.IOclOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver) {
			org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver replacingResolver = (org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.dresdenocl.language.ocl.resource.ocl.IOclReferenceCache) {
					org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver nextResolver = (org.dresdenocl.language.ocl.resource.ocl.IOclReferenceResolver) next;
					if (nextResolver instanceof org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.dresdenocl.language.ocl.resource.ocl.util.OclRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.dresdenocl.language.ocl.resource.ocl.IOclOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.dresdenocl.language.ocl.resource.ocl.util.OclRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.dresdenocl.language.ocl.resource.ocl.IOclOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.dresdenocl.language.ocl.resource.ocl.IOclDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
