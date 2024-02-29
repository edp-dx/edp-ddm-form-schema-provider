# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased]

### Added
- New `GET /api/forms/cards` endpoint in `FormSchemaProviderController` for fetching a list of published card forms.
- Added method declaration `List<JSONObject> getPublishedCards();` in `FormSchemaProviderService` interface.
- Implemented `getPublishedCards` method in `FormSchemaProviderServiceImpl` to retrieve published forms with the 'card' label.
- Added test case `shouldProvideListOfPublishedCards` in `FormSchemaProviderControllerTest` for the new `/cards` endpoint.
