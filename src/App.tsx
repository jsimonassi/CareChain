import React, {useEffect} from 'react';
import {ThemeProvider} from 'styled-components/native';
import {darkTheme} from './constants/themes/darkTheme';
import {MainRouter} from './routes';
import {MetaMaskProvider} from '@metamask/sdk-react-native';
import {useMetaMask} from './hooks/useMetamask';
import {WatchService} from './services/WatchService';

function App(): React.JSX.Element {
  const {loadDataFromCache} = useMetaMask();

  useEffect(() => {
    WatchService.initSdk().then(() => {
      loadDataFromCache();
    });
  }, [loadDataFromCache]);

  return (
    <ThemeProvider theme={darkTheme}>
      <MetaMaskProvider
        sdkOptions={{
          dappMetadata: {
            name: 'Care Chain',
            url: 'https://metamask.github.io/test-dapp/',
            iconUrl:
              'https://cdn.sstatic.net/Sites/stackoverflow/Img/apple-touch-icon.png',
            scheme: 'com.carechain',
          },
        }}>
        <MainRouter />
      </MetaMaskProvider>
    </ThemeProvider>
  );
}

export default App;
