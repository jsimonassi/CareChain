import {DefaultTheme} from 'styled-components/native';

const baseTextStyle = {
  fontStyle: 'normal',
  color: '#3C3744',
};

export const darkTheme: DefaultTheme = {
  type: 'dark',
  palette: {
    primaryColor: '#3E556C',
    primaryColorLight: '#627B94',
    secondaryColor: '#CCCCCC',
    secondaryColorLight: '#EFEFEF',
    error: '#9A2426',
    white: '#FFFF',
    black: '#000',
  },
  typography: {
    text1: {
      ...baseTextStyle,
      fontWeight: 800,
      fontSize: '24px',
      lineHeight: `${24 * 1.5}px`,
    },
    text2: {
      ...baseTextStyle,
      fontWeight: 400,
      fontSize: '20px',
      lineHeight: `${20 * 1.5}px`,
    },
    text3: {
      ...baseTextStyle,
      fontWeight: 400,
      fontSize: '14px',
      lineHeight: `${14 * 1.5}px`,
    },
  },
};
