import React from 'react';
import {ThemeProvider} from 'styled-components/native';
import {darkTheme} from './constants/themes/darkTheme';
import {MainRouter} from './routes';
import {MetaMaskProvider} from '@metamask/sdk-react-native';

function App(): React.JSX.Element {
  return (
    <ThemeProvider theme={darkTheme}>
      <MetaMaskProvider
        sdkOptions={{
          dappMetadata: {
            name: 'Care Chain',
            url: 'https://metamask.github.io/test-dapp/',
            iconUrl:
              'https://cdn.sstatic.net/Sites/stackoverflow/Img/apple-touch-icon.png',
            scheme: 'testdapp',
          },
        }}>
        <MainRouter />
      </MetaMaskProvider>
    </ThemeProvider>
  );
}

export default App;
