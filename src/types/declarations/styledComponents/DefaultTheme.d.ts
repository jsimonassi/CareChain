import 'styled-components/native';

type TypographyItem = Pick<
  CSSObject,
  'fontStyle' | 'fontWeight' | 'fontSize' | 'lineHeight' | 'color'
>;

declare module 'styled-components/native' {
  export interface DefaultTheme {
    type: 'dark' | 'light';
    palette: {
      primaryColor: string;
      primaryColorLight: string;
      secondaryColor: string;
      secondaryColorLight: string;
      error: string;
    };
    typography: {
      text1: TypographyItem;
      text2: TypographyItem;
      text3: TypographyItem;
    };
  }
}
