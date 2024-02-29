# Changelog

## [Unreleased]

### Added
- New API endpoint `GET /api/forms/cards` in `FormSchemaProviderController` to list form schemas marked as 'cards'.
- Method `listCards()` in `FormSchemaProviderService` interface to support the new API endpoint.
- Implementation of `listCards()` method in `FormSchemaProviderServiceImpl` to return a list of form schemas marked as 'cards'.
- Test method `listCards()` in `FormSchemaProviderControllerTest` to ensure the new API endpoint is working as expected.
