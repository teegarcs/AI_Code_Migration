## Migrating from MyCustomButton to Button

### Class Migration:
`com.teegarcs.core_kotlin_android.MyCustomButton` is deprecated and should no longer be used. The out of the box `Button` class should be used in its place. The following changes should be applied to your Button instances: 

### Button Field Mappings:
Migrate the following attributes if they exist. 
- XML Attribute: `my_padding` should now be `padding`
- XML Attribute: `customClick` should now be `onClick`
- XML Attribute: `label` should now be `text`

### Button Class Changes:
- `setCustomClick` should now be `onClickListener`
- `setLabel` should be replaced with `setText` 
- `setText` should receive a string resource id instead of a raw string